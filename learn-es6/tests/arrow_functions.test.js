test('expression bodies', () => {
    let evens = [0, 2, 4, 6]
    let odds = evens.map(v => v + 1)
    expect(odds).toEqual([1, 3, 5, 7])

    // 必须用括号括起来，否则会解释为语句块，报错。
    // 参考：https://es6.ruanyifeng.com/#docs/function#%E7%AE%AD%E5%A4%B4%E5%87%BD%E6%95%B0
    let pairs = evens.map(v => ({ even: v, odd: v + 1 }))
    expect(pairs).toEqual([
        { even: 0, odd: 1 }, { even: 2, odd: 3 },
        { even: 4, odd: 5 }, { even: 6, odd: 7 }
    ])

    let nums = evens.map((v, i) => v + i)
    expect(nums).toEqual([0, 3, 6, 9])
})

test('statment bodies', () => {
    let nums = [1, 5, 10]
    let fives = []
    nums.forEach(v => {
        if (v % 5 == 0) {
            fives.push(v)
        }
    })
    expect(fives).toEqual([5, 10])
})

test('lexical this', () => {
    this.nums = [1, 5, 10]
    this.fives = []
    this.nums.forEach(v => {
        if (v % 5 == 0) {
            this.fives.push(v)
        }
    })
    expect(this.fives).toEqual([5, 10])
})