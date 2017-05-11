// 238. Product of Array Except Self


// Given an array of n integers where n > 1, nums, return an array output such that
// output[i] is equal to the product of all the elements of nums except nums[i].
//
// Solve it without division and in O(n).
//
// For example, given [1,2,3,4], return [24,12,8,6].
//
// Follow up: Could you solve it with constant space complexity? (Note: The output
// array does not count as extra space for the purpose of space complexity
// analysis.)



// Simple Java solution in O(n) without extra space

public class Solution {
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    res[0] = 1;
    for (int i = 1; i < n; i++) {
        res[i] = res[i - 1] * nums[i - 1];
    }
    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
        res[i] *= right;
        right *= nums[i];
    }
    return res;
}



// My simple Java solution

public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    for (int i = 0, tmp = 1; i < nums.length; i++) {
        result[i] = tmp;
        tmp *= nums[i];
    }
    for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
        result[i] *= tmp;
        tmp *= nums[i];
    }
    return result;
}





// O(n) time and O(1) space C++ solution with explanation

class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n=nums.size();
        vector<int> fromBegin(n);
        fromBegin[0]=1;
        vector<int> fromLast(n);
        fromLast[0]=1;

        for(int i=1;i<n;i++){
            fromBegin[i]=fromBegin[i-1]*nums[i-1];
            fromLast[i]=fromLast[i-1]*nums[n-i];
        }

        vector<int> res(n);
        for(int i=0;i<n;i++){
            res[i]=fromBegin[i]*fromLast[n-1-i];
        }
        return res;
    }
};

// We just need to change the two vectors to two integers and note that we should
// do multiplying operations for two related elements of the results vector in each
// loop.

class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n=nums.size();
        int fromBegin=1;
        int fromLast=1;
        vector<int> res(n,1);

        for(int i=0;i<n;i++){
            res[i]*=fromBegin;
            fromBegin*=nums[i];
            res[n-1-i]*=fromLast;
            fromLast*=nums[n-1-i];
        }
        return res;
    }
};




// My solution beats 100% java solutions

// The idea is simply. The product basically is calculated using the numbers before
// the current number and the numbers after the current number. Thus, we can scan
// the array twice. First, we calcuate the running product of the part before the
// current number. Second, we calculate the running product of the part after the
// current number through scanning from the end of the array.

public class Solution {
public int[] productExceptSelf(int[] nums) {
    int leng = nums.length;
    int[] ret = new int[leng];
    if(leng == 0)
        return ret;
    int runningprefix = 1;
    for(int i = 0; i < leng; i++){
        ret[i] = runningprefix;
        runningprefix*= nums[i];
    }
    int runningsufix = 1;
    for(int i = leng -1; i >= 0; i--){
        ret[i] *= runningsufix;
        runningsufix *= nums[i];
    }
    return ret;

}


// Python solution (Accepted), O(n) time, O(1) space
class Solution:
    # @param {integer[]} nums
    # @return {integer[]}
    def productExceptSelf(self, nums):
        p = 1
        n = len(nums)
        output = []
        for i in range(0,n):
            output.append(p)
            p = p * nums[i]
        p = 1
        for i in range(n-1,-1,-1):
            output[i] = output[i] * p
            p = p * nums[i]
        return output
