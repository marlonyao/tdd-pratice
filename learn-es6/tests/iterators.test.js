test('iterator & for-of operator', () => {
    let fibonacci = {
        // 自定义 iterator 方法(Symbol.iterator)，提供迭代器行为
        [Symbol.iterator]() {
            let pre = 0, cur = 1
            return {
                next() {
                    [pre, cur] = [cur, pre + cur]
                    // 迭代器可以返回无限序列
                    return { done: false, value: cur }
                }
            }
        }
    }

    let fibArray = []
    // 使用 for (let ... of ...) 对迭代器进行遍历
    for (let n of fibonacci) {
        if (n > 100) {
            break
        }
        fibArray.push(n)
    }
    expect(fibArray).toEqual([1, 2, 3, 5, 8, 13, 21, 34, 55, 89])
})

