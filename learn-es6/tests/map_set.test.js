test('set data structure', () => {
    let s = new Set()
    s.add('hello').add('goodbye').add('hello')
    expect(s.size).toBe(2)
    // expect(s.has('hello')).toBe(true)
    expect(s).toContain('hello')
    expect(s).toContain('goodbye')
})

test('map data structure', () => {
    let m = new Map()
    let s = Symbol()
    m.set('hello', 42)
    m.set(s, 34)
    expect(m.get('hello')).toBe(42)
    expect(m.get(s)).toBe(34)
})
