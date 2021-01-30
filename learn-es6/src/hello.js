console.log('hello world')

{
    function foo () { return 1 }
    console.log(foo())
    {
        function foo () { return 2 }
        console.log(foo())
    }
    console.log(foo())
}