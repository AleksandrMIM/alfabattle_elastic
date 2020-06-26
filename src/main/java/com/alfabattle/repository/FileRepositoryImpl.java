package com.alfabattle.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.net.URL;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 1:44
 */
@Repository("jsonRepository")
@RequiredArgsConstructor
public class FileRepositoryImpl implements FileRepository {

  private final ObjectMapper objectMapper;

  @SneakyThrows
  @Override
  public <T> @NotNull T read(@NotNull String url, @NotNull Class<T> tClass) {
    return objectMapper.readValue(new URL(url), tClass);
  }
}
