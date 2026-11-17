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
import com.github.tommyettinger.cringe.WangPerlueNoise;

/**
 * Kryo {@link Serializer} for cringe {@link WangPerlueNoise}s.
 */
public class WangPerlueNoiseSerializer extends Serializer<WangPerlueNoise> {

    public WangPerlueNoiseSerializer() {
        setImmutable(false);
        setAcceptsNull(false);
    }

    @Override
    public void write(final Kryo kryo, final Output output, final WangPerlueNoise data) {
        output.writeInt(data.getSeed(), false);
    }

    @Override
    public WangPerlueNoise read(final Kryo kryo, final Input input, final Class<? extends WangPerlueNoise> dataClass) {
        return new WangPerlueNoise(input.readInt(false));
    }

    @Override
    public WangPerlueNoise copy(Kryo kryo, WangPerlueNoise original) {
        return original.copy();
    }
}