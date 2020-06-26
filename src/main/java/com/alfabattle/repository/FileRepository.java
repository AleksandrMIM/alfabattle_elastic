package com.alfabattle.repository;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 1:40
 */
public interface FileRepository {

  @NotNull <T> T read(@NotNull String url, @NotNull Class<T> tClass);
}
