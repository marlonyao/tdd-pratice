test('binary & octal literal', () => {
    // 2进制
    expect(0b111110111).toBe(503)
    // 8进制
    expect(0o767).toBe(503)
})

test('unicode string & regex literal', () => {
    expect("𠮷".length).toBe(2)
    expect("𠮷".match(/./u)[0]).toBe("𠮷")
    expect("𠮷").toBe("\uD842\uDFB7")
    expect("𠮷").toBe("\u{20BB7}")
    expect("𠮷".codePointAt(0)).toBe(0x20BB7)
})