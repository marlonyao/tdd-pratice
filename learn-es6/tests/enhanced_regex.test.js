test('regex sticky matching', () => {
    // y修饰符，叫做“粘连”（sticky）修饰符。
    // 参考：https://es6.ruanyifeng.com/#docs/regex#y-%E4%BF%AE%E9%A5%B0%E7%AC%A6
    var s = 'aaa_aa_a'
    var r1 = /a+/g
    var r2 = /a+/y

    expect(r1.exec(s)[0]).toBe('aaa')
    // g修饰符，下一个匹配只要找到就行了
    expect(r1.exec(s)[0]).toBe('aa')

    expect(r2.exec(s)[0]).toBe('aaa')
    // y修饰符，下一个匹配必须从剩下的第一个字符匹配
    expect(r2.exec(s)).toBe(null)

    r2 = /a+_/y
    expect(r2.exec(s)[0]).toBe('aaa_')
    expect(r2.exec(s)[0]).toBe('aa_');

    // 粘连匹配的好处是性能会比较好，因为不用像全局匹配一样要不断向后查找
    // 见 http://es6-features.org/#RegularExpressionStickyMatching 说明：
    //   Keep the matching position sticky between matches and this way 
    //   support efficient parsing of arbitrary long input strings, even
    //   with an arbitrary number of distinct regular expressions.
})