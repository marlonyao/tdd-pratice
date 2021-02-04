test('class definition', () => {
    class Shape {
        constructor(id, x, y) {
            this.id = id
            this.move(x, y)
        }
        move(x, y) {
            this.x = x
            this.y = y
        }
    }

    let shape = new Shape('id1', 5, 7)
    expect(shape.id).toBe('id1')
    expect(shape.x).toBe(5)
    expect(shape.y).toBe(7)
})

test('class inheritance', () => {
    class Shape {
        constructor(id, x, y) {
            this.id = id
            this.move(x, y)
        }
        move(x, y) {
            this.x = x
            this.y = y
        }
    }

    class Rectange {
        constructor(id, x, y, width, height) {
            super(id, x, y)
            this.width = width
            this.height = height
        }
    }

    let rec = new Rectange('id2', 1, 2, 10, 5)
    expect(rec.id).toBe('id2')
    expect(rec.x).toBe(1)
    expect(rec.y).toBe(2)
    expect(rec.width).toBe(10)
    expect(rec.height).toBe(5)
})