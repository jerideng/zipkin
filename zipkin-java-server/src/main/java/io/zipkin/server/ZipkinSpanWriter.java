/**
 * Copyright 2015 The OpenZipkin Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.zipkin.server;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import io.zipkin.Codec;
import io.zipkin.SpanStore;

@Service
public class ZipkinSpanWriter {
  @Async
  public void write(SpanStore spanStore, Codec codec, byte[] spans) {
    spanStore.accept(codec.readSpans(spans));
  }
}