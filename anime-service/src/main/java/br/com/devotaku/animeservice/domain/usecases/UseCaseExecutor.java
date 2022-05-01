package br.com.devotaku.animeservice.domain.usecases;


import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public interface UseCaseExecutor {

    <R, I extends UseCase.InputValues, O extends UseCase.OutputValues> CompletableFuture<R> execute(
            UseCase<I, O> useCase,
            I inputValues,
            Function<O, R> mapper
    );

}
