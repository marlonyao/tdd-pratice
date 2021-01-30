test('define constants', () => {
    const PI = 3.14;
    expect(PI).toBe(3.14);

    // 不能修改常量
    expect(() => { PI = 3.1415})
        .toThrowError(TypeError);
});