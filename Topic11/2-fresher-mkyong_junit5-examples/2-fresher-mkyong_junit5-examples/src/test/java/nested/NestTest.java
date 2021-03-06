/*
 * (C) Copyright 2017 Boni Garcia (http://bonigarcia.github.io/)
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
package nested;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NestTest {

    @BeforeEach
    void setup1() {
        System.out.println("Setup 1");
    }

    @Test
    void topTest() {
        System.out.println("Test 1");
    }

    @Nested
    class InnerClass1 {
        @BeforeEach
        void setup2() {
            System.out.println("Setup 2");
        }

        @Test
        void innerTest1() {
            System.out.println("Test 2");
        }

        @Nested
        class InnerClass2 {
            @Test
            void innerTest2() {
                System.out.println("Test 3");
            }
        }
    }
}
