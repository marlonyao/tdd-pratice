test('string interpolation', () => {
    var customer = { name: "Foo" }
    var card = { amount: 7, product: "Bar", unitprice: 42 }
    var message = `Hello ${customer.name},
want to buy ${card.amount} ${card.product} for
a total of ${card.amount * card.unitprice} bucks?`
    expect(message).toBe("Hello Foo,\nwant to buy 7 Bar for\na total of 294 bucks?")
})

test('custom interpolation', () => {
    // 参考：https://es6.ruanyifeng.com/#docs/string#%E6%A0%87%E7%AD%BE%E6%A8%A1%E6%9D%BF
    function get(arr, ...values) {
        return [arr, values]
    }

    let bar = "bar", baz = "baz", quux = "quux"
    expect(get`http://example.com/foo?bar=${bar + baz}&quux=${quux}`)
        .toEqual([
            ['http://example.com/foo?bar=', '&quux=', ''],
            ["barbaz", "quux"]
        ])
})

test('raw string access', () => {
    expect(String.raw`foo\n${ 42 }bar`).toBe("foo\\n42bar")
})