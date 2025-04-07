package com.example.myapplication

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import java.util.Scanner
import kotlin.math.max
import kotlin.random.Random

// 컴파일 타임 상수
const val num = 20

fun main() {
    // 출력
    var name = "준영"
    println("Hello ${name}")

    // 변수
    var i : Int = 10
    var point : Double = 3.3

    // 상수
    val num = 20

    // 형변환
    var l = 20L
    l = i.toLong()

    // 문자열
    println(name[0])

    // max, min
    val j = 100
    println(max(i,j))

    // random
    val randomNumber = Random.nextInt(0, 100)
    println(randomNumber)

    // 입력
//    val reader = Scanner(System.`in`)
//    println(reader.nextInt())

    // 조건문
    if (i > 10) {
        println("10 보다 크다")
    } else {
        println("10 보다 작다")
    }

    // 삼항 연산자
    var result = if (i > 10) {
        "10 보다 크다"
    } else {
        "10 보다 작다"
    }
    println(result)

    // 반복문
    val items = listOf(1,2,3,4,5)
    for(item in items) {
        println(item)
    }
    items.forEach{ item ->
        println(item)
    }
    for(i in 0..3){
        println(i)
    }
    for(i in 0..items.size){
        println(i)
    }
    // while, break, continure는 java와 동일하게 지원

    // 리스트
    // 변경 안되는 리스트
    val list = listOf(1,2,3,4,5)

    // 변경 가능한 리스트
    val mutableitems = mutableListOf<Int>(1,2,3,4,5) // 타입 추론을 하기 때문에 타입은 생략 가능

    // 배열
    val array = arrayOf(1,2,3) // 배열은 잘 안씀, 리스트를 씀

    // Null Safety
    val nullSafety: String? = null // 타입 뒤에 ?를 넣어야 null을 명시할 수 있음

    var name2: String = ""
    nullSafety?.let {
        name2 = name
    }

    // 함수
    println(sum(1,1))
    println(sum2(1,1))
    println(sum3(1,1))
    println(sum3(1,1,1)) // c에 기본 값 설정하여 a,b만 입력 해도도 됨(= 메서드를 여러개 만들 필요 없음)

    // 클래스
    val john = Person("John", 20)
    println(john.name)
    println(john.age)
    john.age = 23
    println(john.age)

    // Data 클래스

    val johnData = PersonData("John", 20) // 클래스의 해쉬값을 반환하지 않고 내용을 반환함
    val johnData2 = PersonData("John", 20) // johnData와 비교 시 같다고 나옴
    println(johnData)
    println(johnData2)
    println(johnData == johnData2)
    println(johnData.hobby)
    johnData.some()
    println(johnData.hobby)

    // 타입체크
    val dog = Dog()
    val cat = Cat()

//    cat as Dog //타입 캐스팅
    if (dog is Dog){
        println("멍멍이")
    }

    // 제네릭 사용
    val box = Box(10)
    println(box.value)

    // 콜백 함수 = 함수를 매개변수로 전달하는 함수
    myFunc()
    myFunc(20)
    myFunc {
        println("함수 호출")
    }
    myFunc(20) {
        println("함수 호출")
    }

    // 코루틴 추가 학습 필요
}

// 콜백 함수(고차함수)
fun myFunc(a: Int = 10, callBack : () -> Unit = {}){ // Unit = Void
    println("함수 시작")
    callBack()
    println("함수 끝")
}

// 제네릭 사용법
class Box<T>(var value: T)

//

// 함수
fun sum(a: Int, b: Int) : Int {
    return a + b
}

fun sum2(a: Int, b: Int) : Int = a + b

fun sum3(a: Int, b: Int, c: Int = 0) : Int = a + b + c

// 클래스
class Person(
    val name: String, // 기본적으로 public, private 등 명시를 통해 접근 제어 가능
    var age: Int,
)

// data 클래스
data class PersonData(
    val name: String,
    var age: Int,
) {
    var hobby = "축구"
        private set // 외부에서 set이 불가능
        get() = "취미: $field" // getter 재정의

    init {
        println("init")
    }
    fun some() {
        hobby = "농구"
    }
}


// 상속
abstract class Animal{
    open fun move(){ // open이 있어야 자식 클래스에서 오버라이드 가능
        println("이동")
    }
}
class Dog : Animal(){
    override fun move() {
        println("껑충")
    }
}
class Cat : Animal(){
    override fun move() {
        println("살금")
    }
}

// 인터페이스
interface Drawable {
    fun draw()
}
class Dog2 : Animal(), Drawable{
    override fun move() {
        println("껑충")
    }

    override fun draw() {
        TODO("Not yet implemented")
    }
}
class Cat2 : Animal(), Drawable{
    override fun move() {
        println("살금")
    }

    override fun draw() {
        TODO("Not yet implemented")
    }
}