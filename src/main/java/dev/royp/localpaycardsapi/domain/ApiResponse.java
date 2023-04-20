package dev.royp.localpaycardsapi.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

  private T data;

  private String path;

  @Builder.Default private ZonedDateTime timestamp = ZonedDateTime.now(ZoneOffset.UTC);
}
