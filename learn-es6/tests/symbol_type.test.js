test('symbol type', () => {
    // 任意两个 Symbol 都不一样，即使它们的描述并不一样
    expect(Symbol('foo')).not.toBe(Symbol('foo'))

    const foo = Symbol()
    const bar = Symbol()
    expect(typeof foo).toBe('symbol')
    expect(typeof bar).toBe('symbol')

    let obj = {}
    // 可以指定 Symbol 对象为属性名
    obj[foo] = 'foo'
    obj[bar] = 'bar'

    // JSON.stringify 不会输出 Symbol 类型的key
    expect(JSON.stringify(obj)).toBe('{}')

    expect(Object.keys(obj)).toStrictEqual([])
    expect(Object.getOwnPropertyNames(obj)).toStrictEqual([])
    expect(Object.getOwnPropertySymbols(obj)).toStrictEqual([foo, bar])
})

test('global symbols', () => {
    // Symbol.for(...) 通过名称索引，不会重复创建
    expect(Symbol.for('app.foo')).toBe(Symbol.for('app.foo'))

    const foo = Symbol.for('app.foo')
    const bar = Symbol.for('app.bar')
    expect(Symbol.keyFor(foo)).toBe('app.foo')
    expect(Symbol.keyFor(bar)).toBe('app.bar')
})
