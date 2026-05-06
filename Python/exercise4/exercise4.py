import requests

def task_1_append_logger():
    print("--- Task 1: Append Logger ---")
    note = input("Enter a note for the log: ")
    filename = "session_log.txt"

    try:
        with open(filename, "a") as file:
            file.write(f"{note}" + "\n")
    except FileNotFoundError:
        print(f"File '{filename}' not found.")
    except PermissionError:
        print(f"Permission denied: Unable to append to file '{filename}'.'")

    try:
        with open(filename, "r") as read_file:
            content = read_file.read()
            print(content)
    except PermissionError:
        print(f"Permission denied: Unable to read from file '{filename}'.")
    pass

def task_2_word_count_utility():
    print("--- Task 2: Word Count Utility ---")
    note = "Knowledge is power! Go Lightning! Python makes data easy."
    filename = "lehman_motto.txt"
    count = 0

    try:
        with open(filename, "w") as file:
            file.write(note)
    except PermissionError:
        print(f"Permission denied: Unable to write to file '{filename}'.")
    except FileNotFoundError:
        print(f"File '{filename}' not found.")

    try:
        with open(filename, "r") as read_file:
            content = read_file.read()
            words = content.split(" ")
            for word in words:
                count+= 1
            print(count)
    except PermissionError:
        print(f"Permission denied: Unable to read from file '{filename}'.")
    except FileNotFoundError:
        print(f"File '{filename}' not found.")
    pass

def task_3_api_status_checker():
    print("--- Task 3: API Status Checker ---")
    try:
        response = requests.get("https://jsonplaceholder.typicode.com/posts/101")
        if response.status_code == 200:
            status = response.json()
            print(status)
        elif response.status_code == 404:
            print(f"Error: Post not found.")
    except requests.exceptions.Timeout as e:
        print(f"Timeout error: {e}")
    pass

def task_4_data_filtering():
    print("--- Task 4: Data Filtering ---")
    try:
        response = requests.get("https://jsonplaceholder.typicode.com/users")
        if response.status_code == 200:
            users = response.json()
            for user in users:
                address = user["address"]["suite"]
                if "Suite" in address:
                    name = user["name"]
                    print(f"Name: {name}")
        else:
            print(f"Error: Users not found.")
    except requests.exceptions.Timeout as e:
        print(f"Timeout error: {e}")

def task_5_integration_report():
    print("--- Task 5: Integration Report ---")
    filename = "json_report.txt"
    try:
        response = requests.get("https://jsonplaceholder.typicode.com/posts/1")
        if response.status_code == 200:
            title = response.json()["title"]
            body = response.json()["body"]
        else:
            print(f"Error: Post not found.")
    except requests.exceptions.Timeout as e:
        print(f"Timeout error: {e}")

    try:
        with open(filename, "w") as file:
            file.write(f"{title}")
            file.write(f"\n{body}")
    except PermissionError:
        print(f"Permission denied: Unable to write to file '{filename}'.")
    except FileNotFoundError:
        print(f"File '{filename}' not found.")
    pass

if __name__ == '__main__':
    task_1_append_logger()
    task_2_word_count_utility()
    task_3_api_status_checker()
    task_4_data_filtering()
    task_5_integration_report()
    pass
