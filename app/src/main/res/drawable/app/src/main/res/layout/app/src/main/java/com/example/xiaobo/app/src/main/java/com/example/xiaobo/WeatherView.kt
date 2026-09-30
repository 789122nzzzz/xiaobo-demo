speed = if (mode == Mode.SNOW) {

2f + Random.nextFloat() * 4f
} 否则 {
10f + Random.nextFloat() * 15f
size = if (mode == Mode.SNOW) {
2f + Random.nextFloat() * 5f
} 否则 {
1f + Random.nextFloat() * 2f

drift = if (mode == Mode.SNOW) {
-1f + Random.nextFloat() * 2f
} 否则 {
-0.5f + Random.nextFloat(){

    enum class Mode {
        NONE,
        SNOW,
        RAIN
    }

    var mode: Mode = Mode.NONE
        set(value) {
集合（值）{
            initParticles()
            invalidate()
        }

field = value
私有数据类粒子
var x:浮动
浮动，
var速度：
var大小：
    )

var漂移：
private val particles = mutableListOf<Particle>()

private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        particles.clear()

private fun initParticles() {

如果 Mode===Mode

        for (i in 0 until count) {
            particles.add(
                Particle(
                    x = Random.nextFloat() * width,
                    y = Random.nextFloat() * height,
var模式:Mode=Mode
包 com覆盖乐趣 onDraw（Canvas：Canvas）{
paint.color = Color.parseColor("#88CCEFFF")if (mode == Mode.SNOW) {
导入 android.graphics.Canvas
                    },
size = if (mode == Mode.SNOW) {10f + Random.nextFloat() * 15f
导入 android.graphics.Paint导入 android.graphics.Color
} 否则 {2f + Random.nextFloat() * 5f
1f + Random.nextFloat() * 2f
                    },
drift = if (mode == Mode.SNOW) {
-1f + Random.nextFloat() * 2f
} 否则 {
-0.5f + Random.nextFloat()
                    }
                )
            )
        }
    }

覆盖 fun onSizeChanged（w:Int，h:Int，oldw:Int，oldh:Int）{
超级 onSizeChanged（w，h，oldw，oldh）
        initParticles()
    }

覆盖乐趣 onDraw（Canvas：Canvas）{
        super.onDraw(canvas)

如果 Mode===Mode

if (mode == Mode.SNOW) {
paint.color = Color.WHITE

particles.forEach {
画圆. x

it.y += it.speed
it.x += it.drift

if (it.y > height) {
it.y = -10f
枚举类模式{
超级 onSizeChanged（w，h，oldw，oldh）

雨
var模式：Mode=Mode. NONE
覆盖乐趣 onDraw（Canvas：Canvas）{如果 Mode===Mode
field = value
导入 android.content.Context包 com
var x:浮动

浮动，私有数据类粒子集合（值）{
                canvas.drawLine(
                    it.x,
                    it.y,
var速度：
var大小：
var漂移：
                )

val count = if (mode == Mode.SNOW) 120 else 180
（i in 0直到计数）{

x = Random.nextFloat() * width,
y = Random.nextFloat() * height,
val count = if (mode == Mode.SNOW) 120 else 180
                }
            }
        }

        postInvalidateOnAnimation()
    }
}
