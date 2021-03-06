/*
 * Copyright (C) 2019 The Android Open Source Project
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

package android.net.metrics

import androidx.test.filters.SmallTest
import androidx.test.runner.AndroidJUnit4
import com.android.testutils.assertParcelingIsLossless
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class NetworkEventTest {
    @Test
    fun testConstructorAndParcel() {
        (NetworkEvent.NETWORK_CONNECTED..NetworkEvent.NETWORK_PARTIAL_CONNECTIVITY).forEach {
            var networkEvent = NetworkEvent(it)
            assertEquals(it, networkEvent.eventType)
            assertEquals(0, networkEvent.durationMs)

            networkEvent = NetworkEvent(it, Long.MAX_VALUE)
            assertEquals(it, networkEvent.eventType)
            assertEquals(Long.MAX_VALUE, networkEvent.durationMs)

            assertParcelingIsLossless(networkEvent)
        }
    }
}
