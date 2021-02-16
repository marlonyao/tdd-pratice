test('generator function, iterator protocol', () => {
    // let fibonacci = {
    //     *[Symbol.iterator]() {
    //         let pre = 0, cur = 1
    //         for (;;) {
    //             [pre, cur] = [cur, pre + cur];
    //             yield cur;
    //         }
    //     }
    // }

    let fibonacci = {
        *[Symbol.iterator]() {
            let pre = 0, cur = 1;
            for (;;) {
                [ pre, cur ] = [ cur, pre + cur ];
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