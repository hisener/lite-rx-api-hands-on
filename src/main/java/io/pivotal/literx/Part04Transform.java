package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to transform values.
 *
 * @author Sebastien Deleuze
 */
public class Part04Transform {

//========================================================================================

    // Capitalize the user username, firstname and lastname
    Mono<User> capitalizeOne(Mono<User> mono) {
        return mono.map(this::capitalizeUser);
    }

    private User capitalizeUser(User user) {
        return new User(user.getUsername().toUpperCase(), user.getFirstname().toUpperCase(), user.getLastname().toUpperCase());
    }

//========================================================================================

    // Capitalize the users username, firstName and lastName
    Flux<User> capitalizeMany(Flux<User> flux) {
        return flux.map(this::capitalizeUser);
    }

//========================================================================================

    // Capitalize the users username, firstName and lastName using #asyncCapitalizeUser
    Flux<User> asyncCapitalizeMany(Flux<User> flux) {
        return flux.flatMap(this::asyncCapitalizeUser);
    }

    Mono<User> asyncCapitalizeUser(User u) {
        return Mono.just(capitalizeUser(u));
    }

}
