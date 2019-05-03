package io.pivotal.literx;

import org.assertj.core.util.Lists;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

/**
 * Learn how to create Flux instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux Javadoc</a>
 */
public class Part01Flux {

//========================================================================================

    Flux<String> emptyFlux() {
        return Flux.empty();
    }

//========================================================================================

    Flux<String> fooBarFluxFromValues() {
        return Flux.just("foo", "bar");
    }

//========================================================================================

    Flux<String> fooBarFluxFromList() {
        List<String> list = Lists.newArrayList("foo", "bar");
        return Flux.fromIterable(list);
    }

//========================================================================================

    Flux<String> errorFlux() {
        return Flux.error(new IllegalStateException());
    }

//========================================================================================

    Flux<Long> counter() {
        return Flux.range(0, 10).map(Long::valueOf).delayElements(Duration.ofMillis(100));
    }

}
