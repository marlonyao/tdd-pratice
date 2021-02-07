import { sum, PI } from "../src/lib/math"

test('import { sum, PI } from math', () => {
    expect(sum(PI, PI)).toBe(3.141593 * 2)
})