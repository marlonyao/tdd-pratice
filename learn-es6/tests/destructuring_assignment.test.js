test('array matching', () => {
    let list = [1, 2, 3]
    let [a, , b] = list
    expect(a).toBe(1)
    expect(b).toBe(3);

    [b, a] = [a, b]
    expect(a).toBe(3)
    expect(b).toBe(1)
})

test('object matching, shorthand notation', () => {
    function getASTNode() {
        return {
            op: '+',
            lhs: '3',
            rhs: '5'
        }
    }
    // 必须用 { } 括起来
    let { op, lhs, rhs } = getASTNode()
    expect(op).toBe('+')
    expect(lhs).toBe('3')
    expect(rhs).toBe('5')
})

test('object matching, deep matching', () => {
    function getASTNode() {
        return {
            op: '+',
            lhs: { op: '-', value: 1 },
            rhs: '5'
        }
    }
    // 必须用 { } 括起来
    let { op: a, lhs: { op: b }, rhs: c } = getASTNode()
    expect(a).toBe('+')
    expect(b).toBe('-')
    expect(c).toBe('5')
})

test('object and array matching, default values', () => {
    let obj = { a: 1 }
    let list = [1]
    let { a, b = 2 } = obj
    expect(a).toBe(1)
    expect(b).toBe(2)
    let [x, y = 2] = list
    expect(x).toBe(1)
    expect(y).toBe(2)
})

test('parameter context matching', () => {
    function f([name, val]) {
        expect(name).toBe('bar')
        expect(val).toBe(42)
    }
    f(['bar', 42])

    function g({ name: n, val: v }) {
        expect(n).toBe('foo')
        expect(v).toBe(7)
    }
    g({ name: 'foo', val: 7 })

    function h({ name, val }) {
        expect(name).toBe('bar')
        expect(val).toBe(42)
    }
    h({ name: 'bar', val: 42 })
})

test('fail-soft destructuring', () => {
    let list = [7, 42]
    let [a = 1, b = 2, c = 3, d] = list
    expect(a).toBe(7)
    expect(b).toBe(42)
    expect(c).toBe(3)
    expect(d).toBe(undefined)
})
