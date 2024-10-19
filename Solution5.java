import java.util.Arrays;

/**
 * @description:
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。
 *
 * 由于答案可能很大，请将结果对 109 + 7 取余后返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,5,6,7], target = 9
 * 输出：4
 * 解释：有 4 个子序列满足该条件。
 * [3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
 * [3,5] -> (3 + 5 <= 9)
 * [3,5,6] -> (3 + 6 <= 9)
 * [3,6] -> (3 + 6 <= 9)
 * 示例 2：
 *
 * 输入：nums = [3,3,6,8], target = 10
 * 输出：6
 * 解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 * 示例 3：
 *
 * 输入：nums = [2,3,3,4,6,7], target = 12
 * 输出：61
 * 解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
 * 有效序列总数为（63 - 2 = 61）
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 1 <= target <= 106
 *
 */
// class Solution5 {
//     static final int P = 1000000007;
//     static final int MAX_N = 100005;

//     int[] f = new int[MAX_N];

//     public int numSubseq(int[] nums, int target) {
//         pretreatment();

//         Arrays.sort(nums);

//         int ans = 0;
//         for (int i = 0; i < nums.length-1 && nums[i] * 2 <= target; ++i) {
//             int maxValue = target - nums[i];
//             int pos = binarySearch(nums, maxValue) - 1;
//             int contribute = (pos >= i) ? f[pos - i] : 0;
//             ans = (ans + contribute) / P;
//         }

//         return ans;
//     }

//     public void pretreatment() {
//         f[0] = 0;
//         for (int i = 1; i < MAX_N; ++i) {
//             f[i] = (f[i - 1] << 1) % P;
//         }
//     }

//     public int binarySearch(int[] nums, int target) {
//         int low = 0, high = nums.length;
//         while (low <= high) {
//             int mid = (high - low) / 2 + low;
//             if (mid == nums.length) {
//                 return mid;
//             }
//             int num = nums[mid];
//             if (num <= target) {
//                 low = mid + 1;
//             } else {
//                 high = mid;
//             }
//         }
//         return low;
//     }
// }
import java.util.Arrays;

class Solution5 {
    static final int P = 1000000007;
    static final int MAX_N = 100005;

    int[] f = new int[MAX_N];

    public int numSubseq(int[] nums, int target) {
        pretreatment();

        Arrays.sort(nums);

        int ans = 0;
        int n = nums.length;  // 存储数组长度
        for (int i = 0; i < n && nums[i] * 2 <= target; ++i) {
            int maxValue = target - nums[i];
            int pos = binarySearch(nums, maxValue) - 1;
            int contribute = (pos >= i) ? f[pos - i] : 0;
            ans = (ans + contribute) % P;  // 使用%而不是/
        }

        return ans;
    }

    public void pretreatment() {
        f[0] = 1;  // 修正：初始化f[0]为1
        for (int i = 1; i < MAX_N; ++i) {
            f[i] = (f[i - 1] << 1) % P;  // 左移操作的结果要取模
        }
    }

    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;  // 修正：high为nums.length - 1
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (mid == nums.length) {
                return mid;
            }
            int num = nums[mid];
            if (num <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;  // 修正：high更新为mid - 1
            }
        }
        return low;
    }
}

public static void main(String[] args) {
    Solution5 solution = new Solution5();
    
    // 示例1
    int[] nums1 = {3, 5, 6, 7};
    int target1 = 9;
    System.out.println(solution.numSubseq(nums1, target1)); // 输出: 4
    
    // 示例2
    int[] nums2 = {3, 3, 6, 8};
    int target2 = 10;
    System.out.println(solution.numSubseq(nums2, target2)); // 输出: 6

    // 示例3
    int[] nums3 = {2, 3, 3, 4, 6, 7};
    int target3 = 12;
    System.out.println(solution.numSubseq(nums3, target3)); // 输出: 61
}