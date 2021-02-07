import * as math from "../src/lib/math"
test('import * from math', () => {
    expect(math.sum(1, 2)).toBe(3)
    expect(math.PI).toBe(3.141593)
})

import { sum, PI } from "../src/lib/math"
test('import { sum, PI } from math', () => {
    expect(sum(PI, PI)).toBe(3.141593 * 2)
})