test('default param values', () => {
    function f(x, y = 7, z = 42) {
        return x + y + z
    }
    expect(f(1)).toBe(50)
})

test('rest parameter', () => {
    function f(x, y, ...a) {
        return (x + y) * a.length
    }
    expect(f(1, 2, "hello", true, 7)).toBe(9)
})

test('spread operator', () => {
    let params = ['hello', true, 7]
    let other = [1, 2, ...params]
    expect(other).toEqual([1, 2, 'hello', true, 7])

    function f(x, y, ...a) {
        return (x + y) * a.length
    }

    expect(f(1, 2, ...params)).toBe(9)

    let str = 'foo'
    let chars = [...str]
    expect(chars).toEqual(['f', 'o', 'o'])
})