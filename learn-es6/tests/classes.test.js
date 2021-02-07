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

    class Rectange extends Shape {
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

test('class inheritance, from expressions', () => {
    var aggregation = (baseClass, ...mixins) => {
        let base = class _Combined extends baseClass {
            constructor(...args) {
                super(...args);
                mixins.forEach((mixin) => {
                    mixin.prototype.initializer.call(this);
                });
            }
        };
        let copyProps = (target, source) => {
            Object.getOwnPropertyNames(source)
                .concat(Object.getOwnPropertySymbols(source))
                .forEach((prop) => {
                    if (prop.match(/^(?:constructor|prototype|arguments|caller|name|bind|call|apply|toString|length)$/))
                        return
                    Object.defineProperty(target, prop, Object.getOwnPropertyDescriptor(source, prop))
                })
        }
        mixins.forEach((mixin) => {
            copyProps(base.prototype, mixin.prototype);
            copyProps(base, mixin);
        });
        return base;
    };

    class Colored {
        initializer() { this._color = "white"; }
        get color() { return this._color; }
        set color(v) { this._color = v; }
    }

    class ZCoord {
        initializer() { this._z = 0; }
        get z() { return this._z; }
        set z(v) { this._z = v; }
    }

    class Shape {
        constructor(x, y) { this._x = x; this._y = y; }
        get x() { return this._x; }
        set x(v) { this._x = v; }
        get y() { return this._y; }
        set y(v) { this._y = v; }
    }

    class Rectangle extends aggregation(Shape, Colored, ZCoord) { }

    var rect = new Rectangle(7, 42);
    rect.z = 1000;
    rect.color = "red";
    expect(rect.x).toBe(7)
    expect(rect.y).toBe(42)
    expect(rect.z).toBe(1000)
    expect(rect.color).toBe('red')
})