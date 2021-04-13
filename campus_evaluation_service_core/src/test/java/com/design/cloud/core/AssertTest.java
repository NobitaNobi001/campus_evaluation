package com.design.cloud.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author ezuy
 * @date 21/4/8 13:27
 */
public class AssertTest {

    /**
     * 传统解决
     */
    @Test
    public void test1() {

        Object o = null;
        if (o == null) {
            throw new IllegalArgumentException("参数错误");
        }
    }

    /**
     * 使用断言
     */
    @Test
    public void testAssert() {
        Object o = null;
        Assert.assertNotNull((String) o, "参数错误");
    }
}
