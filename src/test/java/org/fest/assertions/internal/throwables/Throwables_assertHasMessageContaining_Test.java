/*
 * Created on Dec 26, 2010
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 * 
 * Copyright @2010-2011 the original author or authors.
 */
package org.fest.assertions.internal.throwables;

import static org.fest.assertions.error.ShouldEndWith.shouldEndWith;
import static org.fest.util.FailureMessages.actualIsNull;
import static org.fest.assertions.test.TestData.someInfo;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import org.fest.assertions.core.AssertionInfo;
import org.fest.assertions.internal.Throwables;
import org.fest.assertions.internal.ThrowablesBaseTest;

/**
 * Tests for <code>{@link Throwables#assertHasMessageEndingWith(AssertionInfo, Throwable, String)}</code>.
 * 
 * @author Joel Costigliola
 */
public class Throwables_assertHasMessageContaining_Test extends ThrowablesBaseTest {

  @Test
  public void should_pass_if_actual_has_message_ending_with_expected_description() {
    throwables.assertHasMessageEndingWith(someInfo(), actual, "sage");
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    throwables.assertHasMessageEndingWith(someInfo(), null, "Throwable");
  }

  @Test
  public void should_fail_if_actual_has_message_not_ending_with_expected_description() {
    AssertionInfo info = someInfo();
    try {
      throwables.assertHasMessageEndingWith(info, actual, "expected end");
      fail("AssertionError expected");
    } catch (AssertionError err) {
      verify(failures).failure(info, shouldEndWith(actual.getMessage(), "expected end"));
    }
  }
}
