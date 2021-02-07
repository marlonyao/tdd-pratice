import exp, { PI, e } from "../src/lib/mathplusplus";
test('Default & Wildcard', () => {
    expect(exp(PI)).toBeCloseTo(23.14)
})