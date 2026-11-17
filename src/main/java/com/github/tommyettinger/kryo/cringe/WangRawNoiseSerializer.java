/*
 * Copyright (c) 2022-2024 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.github.tommyettinger.kryo.cringe;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.github.tommyettinger.cringe.WangRawNoise;

/**
 * Kryo {@link Serializer} for cringe {@link WangRawNoise}s. This is less space-efficient
 * than storing a known class that extends WangRawNoise.
 */
public class WangRawNoiseSerializer extends Serializer<WangRawNoise> {

    public WangRawNoiseSerializer() {
        setImmutable(false);
        setAcceptsNull(false);
    }

    @Override
    public void write(final Kryo kryo, final Output output, final WangRawNoise data) {
        output.writeString(WangRawNoise.Serializer.serialize(data));
    }

    @Override
    public WangRawNoise read(final Kryo kryo, final Input input, final Class<? extends WangRawNoise> dataClass) {
        return WangRawNoise.Serializer.deserialize(input.readString());
    }

    @Override
    public WangRawNoise copy(Kryo kryo, WangRawNoise original) {
        return original.copy();
    }
}