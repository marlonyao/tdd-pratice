import * as math from "../src/math"
test('import * from math', () => {
    expect(math.sum(1, 2)).toBe(3)
    expect(math.PI).toBe(3.141593)
})