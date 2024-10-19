package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L2022211854_5_Test {

  @Test
  void testNumSubseq_ValidCase1() {
    // 测试目的：验证正常情况
    // 测试用例：[3, 5, 6, 7], target = 9
    Solution5 solution = new Solution5();
    int[] nums = {3, 5, 6, 7};
    int target = 9;
    assertEquals(4, solution.numSubseq(nums, target));
  }

  @Test
  void testNumSubseq_ValidCase2() {
    // 测试目的：验证包含重复元素的情况
    // 测试用例：[3, 3, 6, 8], target = 10
    Solution5 solution = new Solution5();
    int[] nums = {3, 3, 6, 8};
    int target = 10;
    assertEquals(6, solution.numSubseq(nums, target));
  }

  @Test
  void testNumSubseq_ValidCase3() {
    // 测试目的：验证边界条件
    // 测试用例：[2, 3, 3, 4, 6, 7], target = 12
    Solution5 solution = new Solution5();
    int[] nums = {2, 3, 3, 4, 6, 7};
    int target = 12;
    assertEquals(61, solution.numSubseq(nums, target));
  }

  @Test
  void testNumSubseq_EmptyArray() {
    // 测试目的：验证空数组输入的处理
    // 测试用例：[], target = 5
    Solution5 solution = new Solution5();
    int[] nums = {};
    int target = 5;
    assertEquals(0, solution.numSubseq(nums, target)); // 期望返回0
  }

  @Test
  void testNumSubseq_NoValidSubsequence() {
    // 测试目的：验证没有有效子序列的情况
    // 测试用例：[10, 11], target = 15
    Solution5 solution = new Solution5();
    int[] nums = {10, 11};
    int target = 15;
    assertEquals(0, solution.numSubseq(nums, target)); // 期望返回0
  }
}
