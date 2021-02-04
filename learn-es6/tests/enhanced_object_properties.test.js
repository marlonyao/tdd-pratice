test('property shorthand', () => {
    let x = 1, y = 2
    let obj = {x, y}
    expect(obj.x).toBe(1)
    expect(obj.y).toBe(2)
})

test('computed property names', () => {
    function quux() {
        return '_quux'
    }

    let obj = {
        foo: 'bar',
        [ 'baz' + quux() ]: 42
    }
    expect(obj.baz_quux).toBe(42)
})

test('method properties', () => {
    let obj = {
        foo(a, b) {
            return 'foo(' + a + ',' + b + ')'
        },
        bar(x, y) {
            return 'bar(' + x + ',' + y + ')'
        }
    }
    expect(obj.foo(1, 2)).toBe('foo(1,2)')
    expect(obj.bar(3, 4)).toBe('bar(3,4)')
})