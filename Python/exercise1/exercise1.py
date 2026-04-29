def exercise_1_basics():
    course = "CMP 269"
    students = 27

    print(f"The course {course} has {students} students.")

def exercise_2_collections():
    colors = ["red", "green", "blue", "yellow", "orange"]
    colors.append("purple")

    grades = {
        "name": "Judd",
        "GPA" : "3.7"
    }
    print(colors)
    print(grades)

def exercise_3_logic():
    numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    evens = []

    for number in numbers:
        if number % 2 == 0:
            evens.append(number)

    print(numbers)
    print(evens)

if __name__ == '__main__':
    print("--- Exercise 1 ---")
    exercise_1_basics()
    print("\n--- Exercise 2 ---")
    exercise_2_collections()
    print("\n--- Exercise 3 ---")
    exercise_3_logic()
