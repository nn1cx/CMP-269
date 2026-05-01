class LehmanCourse:
    def __init__(self, course_name, credits):
        self.course_name = course_name
        self.credits = credits
        self.student_count = 0

    def enroll_student(self):
        self.student_count += 1

    def display_info(self):
        print(f"Course Name: {self.course_name}")
        print(f"Credits: {self.credits}")
        print(f"Student Count: {self.student_count}")

class LabCourse(LehmanCourse):
    def __init__(self, course_name, credits, lab_fee):
        super().__init__(course_name, credits)
        self.student_count = 0
        self.lab_fee = lab_fee

    def display_info(self):
        super().display_info()
        print(f"Lab Fee: ${self.lab_fee}")

class Professor:
    def get_role(self):
        return "Teaching and Research"

class Student:
    def get_role(self):
        return "Learning and Coding"

def print_role(person):
    print(person.get_role())
    print()

if __name__ == "__main__":
    random_course = LehmanCourse("CMP 269", 4)
    random_course.enroll_student()
    random_course.display_info()

    random_course2 = LabCourse("CMP 333", 4, 50)
    random_course2.enroll_student()
    random_course2.enroll_student()
    random_course2.display_info()

    person1 = Professor()
    person2 = Student()
    print_role(person1)
    print_role(person2)
