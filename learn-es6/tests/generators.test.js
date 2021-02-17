test('generator function, iterator protocol', () => {
    let fibonacci = {
        // 在 generator 中可以使用 yield 关键字，定义 generator 时
        // 需要在普通函数定义之前加上 '*' 号
        *[Symbol.iterator]() {
            let pre = 0, cur = 1;
            for (; ;) {
                [pre, cur] = [cur, pre + cur];
                yield cur;
            }
        }
    }

    let fibArray = []
    // 使用 for (let ... of ...) 对迭代器进行遍历
    for (let n of fibonacci) {
        if (n > 100) {
            break;
        }
        fibArray.push(n)
    }
    expect(fibArray).toEqual([1, 2, 3, 5, 8, 13, 21, 34, 55, 89])
})

test('generator function, direct use', () => {
    function* range(start, end, step) {
        while (start < end) {
            yield start
            start += step
        }
    }

    expect(Array.from(range(0, 9, 2))).toEqual([0, 2, 4, 6, 8])
})

test('generator matching', () => {
    let fibonacci = function* (numbers) {
        let pre = 0, cur = 1
        while (numbers-- > 0) {
            [pre, cur] = [cur, pre + cur]
            yield cur
        }
    }

    let numbers = [...fibonacci(5)]
    expect(numbers).toEqual([1, 2, 3, 5, 8])

    let [n1, n2, n3, ...others] = fibonacci(5)
    expect(n1).toBe(1)
    expect(n2).toBe(2)
    expect(n3).toBe(3)
    expect(others).toEqual([5, 8])
})
