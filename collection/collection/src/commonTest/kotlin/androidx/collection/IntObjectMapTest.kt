/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.collection

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertSame
import kotlin.test.assertTrue

// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// DO NOT MAKE CHANGES to the kotlin source file.
//
// This file was generated from a template in the template directory.
// Make a change to the original template and run the generateCollections.sh script
// to ensure the change is available on all versions of the map.
//
// Note that there are 3 templates for maps, one for object-to-primitive, one
// for primitive-to-object and one for primitive-to-primitive. Also, the
// object-to-object is ScatterMap.kt, which doesn't have a template.
// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

class IntObjectMapTest {
    @Test
    fun intObjectMap() {
        val map = MutableIntObjectMap<String>()
        assertEquals(7, map.capacity)
        assertEquals(0, map.size)
    }

    @Test
    fun testEmptyIntObjectMap() {
        val map = emptyIntObjectMap<String>()
        assertEquals(0, map.capacity)
        assertEquals(0, map.size)

        assertSame(emptyIntObjectMap<String>(), map)
    }

    @Test
    fun intObjectMapFunction() {
        val map = mutableIntObjectMapOf<String>()
        assertEquals(7, map.capacity)
        assertEquals(0, map.size)
    }

    @Test
    fun zeroCapacityHashMap() {
        val map = MutableIntObjectMap<String>(0)
        assertEquals(0, map.capacity)
        assertEquals(0, map.size)
    }

    @Test
    fun intObjectMapWithCapacity() {
        // When unloading the suggested capacity, we'll fall outside of the
        // expected bucket of 2047 entries, and we'll get 4095 instead
        val map = MutableIntObjectMap<String>(1800)
        assertEquals(4095, map.capacity)
        assertEquals(0, map.size)
    }

    @Test
    fun intObjectMapPairsFunction() {
        val map = mutableIntObjectMapOf(
            1 to "World",
            2 to "Monde"
        )
        assertEquals(2, map.size)
        assertEquals("World", map[1])
        assertEquals("Monde", map[2])
    }

    @Test
    fun addToMap() {
        val map = MutableIntObjectMap<String>()
        map[1] = "World"

        assertEquals(1, map.size)
        assertEquals("World", map[1])
    }

    @Test
    fun insertIndex0() {
        val map = MutableIntObjectMap<String>()
        map.put(1, "World")
        assertEquals("World", map[1])
    }

    @Test
    fun addToSizedMap() {
        val map = MutableIntObjectMap<String>(12)
        map[1] = "World"

        assertEquals(1, map.size)
        assertEquals("World", map[1])
    }

    @Test
    fun addToSmallMap() {
        val map = MutableIntObjectMap<String>(2)
        map[1] = "World"

        assertEquals(1, map.size)
        assertEquals(7, map.capacity)
        assertEquals("World", map[1])
    }

    @Test
    fun addToZeroCapacityMap() {
        val map = MutableIntObjectMap<String>(0)
        map[1] = "World"

        assertEquals(1, map.size)
        assertEquals("World", map[1])
    }

    @Test
    fun replaceExistingKey() {
        val map = MutableIntObjectMap<String>()
        map[1] = "World"
        map[1] = "Monde"

        assertEquals(1, map.size)
        assertEquals("Monde", map[1])
    }

    @Test
    fun put() {
        val map = MutableIntObjectMap<String?>()

        assertNull(map.put(1, "World"))
        assertEquals("World", map.put(1, "Monde"))
        assertNull(map.put(2, null))
        assertNull(map.put(2, "Monde"))
    }

    @Test
    fun putAllArray() {
        val map = MutableIntObjectMap<String?>()
        map[1] = "World"
        map[2] = null

        map.putAll(arrayOf(3 to "Welt", 7 to "Mundo"))

        assertEquals(4, map.size)
        assertEquals("Welt", map[3])
        assertEquals("Mundo", map[7])
    }

    @Test
    fun putAllMap() {
        val map = MutableIntObjectMap<String?>()
        map[1] = "World"
        map[2] = null

        map.putAll(mutableIntObjectMapOf(3 to "Welt", 7 to "Mundo"))

        assertEquals(4, map.size)
        assertEquals("Welt", map[3])
        assertEquals("Mundo", map[7])
    }

    @Test
    fun plus() {
        val map = MutableIntObjectMap<String>()
        map += 1 to "World"

        assertEquals(1, map.size)
        assertEquals("World", map[1])
    }

    @Test
    fun plusMap() {
        val map = MutableIntObjectMap<String>()
        map += intObjectMapOf(3 to "Welt", 7 to "Mundo")

        assertEquals(2, map.size)
        assertEquals("Welt", map[3])
        assertEquals("Mundo", map[7])
    }

    @Test
    fun plusArray() {
        val map = MutableIntObjectMap<String>()
        map += arrayOf(3 to "Welt", 7 to "Mundo")

        assertEquals(2, map.size)
        assertEquals("Welt", map[3])
        assertEquals("Mundo", map[7])
    }

    @Test
    fun nullValue() {
        val map = MutableIntObjectMap<String?>()
        map[1] = null

        assertEquals(1, map.size)
        assertNull(map[1])
    }

    @Test
    fun findNonExistingKey() {
        val map = MutableIntObjectMap<String?>()
        map[1] = "World"

        assertNull(map[2])
    }

    @Test
    fun getOrDefault() {
        val map = MutableIntObjectMap<String?>()
        map[1] = "World"

        assertEquals("Monde", map.getOrDefault(2, "Monde"))
    }

    @Test
    fun getOrElse() {
        val map = MutableIntObjectMap<String?>()
        map[1] = "World"
        map[2] = null

        assertEquals("Monde", map.getOrElse(2) { "Monde" })
        assertEquals("Welt", map.getOrElse(3) { "Welt" })
    }

    @Test
    fun getOrPut() {
        val map = MutableIntObjectMap<String?>()
        map[1] = "World"

        var counter = 0
        map.getOrPut(1) {
            counter++
            "Monde"
        }
        assertEquals("World", map[1])
        assertEquals(0, counter)

        map.getOrPut(2) {
            counter++
            "Monde"
        }
        assertEquals("Monde", map[2])
        assertEquals(1, counter)

        map.getOrPut(2) {
            counter++
            "Welt"
        }
        assertEquals("Monde", map[2])
        assertEquals(1, counter)

        map.getOrPut(3) {
            counter++
            null
        }
        assertNull(map[3])
        assertEquals(2, counter)

        map.getOrPut(3) {
            counter++
            "Welt"
        }
        assertEquals("Welt", map[3])
        assertEquals(3, counter)
    }

    @Test
    fun remove() {
        val map = MutableIntObjectMap<String?>()
        assertNull(map.remove(1))

        map[1] = "World"
        assertEquals("World", map.remove(1))
        assertEquals(0, map.size)

        map[1] = null
        assertNull(map.remove(1))
        assertEquals(0, map.size)
    }

    @Test
    fun removeThenAdd() {
        // Use a size of 6 to fit in a single entry in the metadata table
        val map = MutableIntObjectMap<String>(6)
        map[1] = "World"
        map[2] = "Monde"
        map[3] = "Welt"
        map[4] = "Sekai"
        map[5] = "Mondo"
        map[6] = "Sesang"

        // Removing all the entries will mark the medata as deleted
        map.remove(1)
        map.remove(2)
        map.remove(3)
        map.remove(4)
        map.remove(5)
        map.remove(6)

        assertEquals(0, map.size)

        val capacity = map.capacity

        // Make sure reinserting an entry after filling the table
        // with "Deleted" markers works
        map[7] = "Mundo"

        assertEquals(1, map.size)
        assertEquals(capacity, map.capacity)
    }

    @Test
    fun removeIf() {
        val map = MutableIntObjectMap<String>()
        map[1] = "World"
        map[2] = "Monde"
        map[3] = "Welt"
        map[4] = "Sekai"
        map[5] = "Mondo"
        map[6] = "Sesang"

        map.removeIf { key, value ->
            key == 1 || key == 3 || value.startsWith('S')
        }

        assertEquals(2, map.size)
        assertEquals("Monde", map[2])
        assertEquals("Mondo", map[5])
    }

    @Test
    fun minus() {
        val map = MutableIntObjectMap<String>()
        map[1] = "World"
        map[2] = "Monde"
        map[3] = "Welt"

        map -= 1

        assertEquals(2, map.size)
        assertNull(map[1])
    }

    @Test
    fun minusArray() {
        val map = MutableIntObjectMap<String>()
        map[1] = "World"
        map[2] = "Monde"
        map[3] = "Welt"

        map -= intArrayOf(3, 2)

        assertEquals(1, map.size)
        assertNull(map[3])
        assertNull(map[2])
    }

    @Test
    fun minusSet() {
        val map = MutableIntObjectMap<String>()
        map[1] = "World"
        map[2] = "Monde"
        map[3] = "Welt"

        map -= intSetOf(3, 2)

        assertEquals(1, map.size)
        assertNull(map[3])
        assertNull(map[2])
    }

    @Test
    fun minusList() {
        val map = MutableIntObjectMap<String>()
        map[1] = "World"
        map[2] = "Monde"
        map[3] = "Welt"

        map -= intListOf(3, 2)

        assertEquals(1, map.size)
        assertNull(map[3])
        assertNull(map[2])
    }

    @Test
    fun conditionalRemove() {
        val map = MutableIntObjectMap<String?>()
        assertFalse(map.remove(1, "World"))

        map[1] = "World"
        assertTrue(map.remove(1, "World"))
        assertEquals(0, map.size)
    }

    @Test
    fun insertManyEntries() {
        val map = MutableIntObjectMap<String>()

        for (i in 0 until 1700) {
            map[i.toInt()] = i.toString()
        }

        assertEquals(1700, map.size)
    }

    @Test
    fun forEach() {
        for (i in 0..48) {
            val map = MutableIntObjectMap<String>()

            for (j in 0 until i) {
                map[j.toInt()] = j.toString()
            }

            var counter = 0
            map.forEach { key, value ->
                assertEquals(key.toInt().toString(), value)
                counter++
            }

            assertEquals(i, counter)
        }
    }

    @Test
    fun forEachKey() {
        for (i in 0..48) {
            val map = MutableIntObjectMap<String>()

            for (j in 0 until i) {
                map[j.toInt()] = j.toString()
            }

            var counter = 0
            map.forEachKey { key ->
                assertEquals(key.toInt().toString(), map[key])
                counter++
            }

            assertEquals(i, counter)
        }
    }

    @Test
    fun forEachValue() {
        for (i in 0..48) {
            val map = MutableIntObjectMap<String>()

            for (j in 0 until i) {
                map[j.toInt()] = j.toString()
            }

            var counter = 0
            map.forEachValue { value ->
                assertNotNull(value.toIntOrNull())
                counter++
            }

            assertEquals(i, counter)
        }
    }

    @Test
    fun clear() {
        val map = MutableIntObjectMap<String>()

        for (i in 0 until 32) {
            map[i.toInt()] = i.toString()
        }

        val capacity = map.capacity
        map.clear()

        assertEquals(0, map.size)
        assertEquals(capacity, map.capacity)
    }

    @Test
    fun string() {
        val map = MutableIntObjectMap<String?>()
        assertEquals("{}", map.toString())

        map[1] = "World"
        map[2] = "Monde"
        val oneKey = 1.toString()
        val twoKey = 2.toString()
        assertTrue(
            "{$oneKey=World, $twoKey=Monde}" == map.toString() ||
                "{$twoKey=Monde, $oneKey=World}" == map.toString()
        )

        map.clear()
        map[1] = null
        assertEquals("{$oneKey=null}", map.toString())

        val selfAsValueMap = MutableIntObjectMap<Any>()
        selfAsValueMap[1] = selfAsValueMap
        assertEquals("{$oneKey=(this)}", selfAsValueMap.toString())
    }

    @Test
    fun equals() {
        val map = MutableIntObjectMap<String?>()
        map[1] = "World"
        map[2] = null

        assertFalse(map.equals(null))
        assertEquals(map, map)

        val map2 = MutableIntObjectMap<String?>()
        map2[2] = null

        assertNotEquals(map, map2)

        map2[1] = "World"
        assertEquals(map, map2)
    }

    @Test
    fun containsKey() {
        val map = MutableIntObjectMap<String?>()
        map[1] = "World"
        map[2] = null

        assertTrue(map.containsKey(1))
        assertFalse(map.containsKey(3))
    }

    @Test
    fun contains() {
        val map = MutableIntObjectMap<String?>()
        map[1] = "World"
        map[2] = null

        assertTrue(1 in map)
        assertFalse(3 in map)
    }

    @Test
    fun containsValue() {
        val map = MutableIntObjectMap<String?>()
        map[1] = "World"
        map[2] = null

        assertTrue(map.containsValue("World"))
        assertTrue(map.containsValue(null))
        assertFalse(map.containsValue("Monde"))
    }

    @Test
    fun empty() {
        val map = MutableIntObjectMap<String?>()
        assertTrue(map.isEmpty())
        assertFalse(map.isNotEmpty())
        assertTrue(map.none())
        assertFalse(map.any())

        map[1] = "World"

        assertFalse(map.isEmpty())
        assertTrue(map.isNotEmpty())
        assertTrue(map.any())
        assertFalse(map.none())
    }

    @Test
    fun count() {
        val map = MutableIntObjectMap<String>()
        assertEquals(0, map.count())

        map[1] = "World"
        assertEquals(1, map.count())

        map[2] = "Monde"
        map[3] = "Welt"
        map[4] = "Sekai"
        map[5] = "Mondo"
        map[6] = "Sesang"

        assertEquals(2, map.count { key, _ -> key < 3 })
        assertEquals(0, map.count { key, _ -> key < 0 })
    }

    @Test
    fun any() {
        val map = MutableIntObjectMap<String>()
        map[1] = "World"
        map[2] = "Monde"
        map[3] = "Welt"
        map[4] = "Sekai"
        map[5] = "Mondo"
        map[6] = "Sesang"

        assertTrue(map.any { key, _ -> key > 5 })
        assertFalse(map.any { key, _ -> key < 0 })
    }

    @Test
    fun all() {
        val map = MutableIntObjectMap<String>()
        map[1] = "World"
        map[2] = "Monde"
        map[3] = "Welt"
        map[4] = "Sekai"
        map[5] = "Mondo"
        map[6] = "Sesang"

        assertTrue(map.all { key, value -> key < 7 && value.length > 0 })
        assertFalse(map.all { key, _ -> key < 6 })
    }
}
