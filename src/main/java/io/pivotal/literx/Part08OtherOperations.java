package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to use various other operators.
 *
 * @author Sebastien Deleuze
 */
public class Part08OtherOperations {

//========================================================================================

    Flux<User> userFluxFromStringFlux(Flux<String> usernameFlux, Flux<String> firstnameFlux, Flux<String> lastnameFlux) {
        return Flux.zip(usernameFlux, firstnameFlux, lastnameFlux).flatMap(tupple -> Flux.just(new User(tupple.getT1(), tupple.getT2(), tupple.getT3())));
    }

//========================================================================================

    Mono<User> useFastestMono(Mono<User> mono1, Mono<User> mono2) {
        return Mono.first(mono1, mono2);
    }

//========================================================================================

    Flux<User> useFastestFlux(Flux<User> flux1, Flux<User> flux2) {
        return Flux.first(flux1, flux2);
    }

//========================================================================================

    Mono<Void> fluxCompletion(Flux<User> flux) {
        return flux.thenEmpty(Mono.empty());
    }

//========================================================================================

    Mono<User> nullAwareUserToMono(User user) {
        return Mono.justOrEmpty(user);
    }

//========================================================================================

    Mono<User> emptyToSkyler(Mono<User> mono) {
        return mono.defaultIfEmpty(User.SKYLER);
    }

}
