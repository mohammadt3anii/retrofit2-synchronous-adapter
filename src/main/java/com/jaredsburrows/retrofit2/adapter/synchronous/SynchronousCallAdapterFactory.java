package com.jaredsburrows.retrofit2.adapter.synchronous;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * Creates a synchronous call adapters for that uses the same thread for both I/O and
 * application-level callbacks.
 *
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
public final class SynchronousCallAdapterFactory extends CallAdapter.Factory {
  private SynchronousCallAdapterFactory() {
  }

  public static CallAdapter.Factory create() {
    return new SynchronousCallAdapterFactory();
  }

  @Override
  public @Nullable CallAdapter<?, ?> get(@Nonnull Type returnType,
      @Nonnull Annotation[] annotations,
      @Nonnull Retrofit retrofit) {
    if (getRawType(returnType) == Call.class) return null;

    return new SynchronousCallAdapter<>(returnType);
  }
}
