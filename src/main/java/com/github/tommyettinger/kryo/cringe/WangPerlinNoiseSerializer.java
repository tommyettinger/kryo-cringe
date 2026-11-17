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
import com.github.tommyettinger.cringe.WangPerlinNoise;

/**
 * Kryo {@link Serializer} for cringe {@link WangPerlinNoise}s.
 */
public class WangPerlinNoiseSerializer extends Serializer<WangPerlinNoise> {

    public WangPerlinNoiseSerializer() {
        setImmutable(false);
        setAcceptsNull(false);
    }

    @Override
    public void write(final Kryo kryo, final Output output, final WangPerlinNoise data) {
        output.writeInt(data.getSeed(), false);
    }

    @Override
    public WangPerlinNoise read(final Kryo kryo, final Input input, final Class<? extends WangPerlinNoise> dataClass) {
        return new WangPerlinNoise(input.readInt(false));
    }

    @Override
    public WangPerlinNoise copy(Kryo kryo, WangPerlinNoise original) {
        return original.copy();
    }
}