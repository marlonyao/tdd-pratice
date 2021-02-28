test('hooking into runtime-level object meta operators', () => {
    let target = {
        foo: 'welcome, foo'
    }

    let proxy = new Proxy(target, {
        get (receiver, propKey) {
            return propKey in receiver ? receiver[propKey] : `hello, ${propKey}`
        }
    })

    expect(proxy.foo).toBe('welcome, foo')
    expect(proxy.bar).toBe('hello, bar')
})