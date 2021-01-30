test('block scoped variables', () => {
    let a = [1, 2, 3]
    for (let i = 0; i < a.length; i++) {
        let x = a[i];
        expect(x).toBe(a[i]);
    }
    let callbacks = [];
    for (let i = 0; i <= 2; i++) {
        callbacks[i] = function () { return i * 2; };
    }
    expect(callbacks[0]()).toBe(0);
    expect(callbacks[1]()).toBe(2);
    expect(callbacks[2]()).toBe(4);
});

// 为什么必须使用严格模式才能通过？在Chrome里和node里都没有问题
test('block scoped functions', () => {
    'use strict'
    function foo() { return 1 }
    expect(foo()).toBe(1)
    {
        function foo() { return 2 }
        expect(foo()).toBe(2)
    }
    expect(foo()).toBe(1);
})