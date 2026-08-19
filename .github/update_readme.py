import os
import re


ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
README_PATH = os.path.join(ROOT, "README.md")


# Topics based on LeetCode problem information.
# Add more mappings here as you solve more problems.
TOPIC_MAP = {
    "0001": ["Array", "Hash Table"],
    "0009": ["Math"],
    "0026": ["Array", "Two Pointers"],
    "0027": ["Array", "Two Pointers"],
    "0035": ["Array", "Binary Search"],
    "0053": ["Array", "Dynamic Programming"],
    "0080": ["Array", "Two Pointers"],
    "0204": ["Math", "Enumeration", "Number Theory", "Primality Test", "Sieve Theory"],
    "0206": ["Linked List"],
    "0283": ["Array", "Two Pointers"],
    "0509": ["Math", "Recursion", "Dynamic Programming", "Memoization"],
    "0704": ["Array", "Binary Search"],
    "1729": ["Database"],
    "3300": ["Array"],
    "3688": ["Array", "Bit Manipulation", "Simulation"],
}


def get_problems():
    problems = []

    for item in os.listdir(ROOT):
        path = os.path.join(ROOT, item)

        if not os.path.isdir(path):
            continue

        match = re.match(r"^(\d{4})-(.+)$", item)

        if not match:
            continue

        number = match.group(1)
        slug = match.group(2)

        title = slug.replace("-", " ").title()

        problems.append({
            "number": number,
            "slug": slug,
            "title": title,
        })

    problems.sort(key=lambda x: int(x["number"]))

    return problems


def create_topic_section(problems):
    topics = {}

    for problem in problems:
        number = problem["number"]

        for topic in TOPIC_MAP.get(number, ["Other"]):
            topics.setdefault(topic, []).append(problem)

    section = "## 🧠 LeetCode Topics\n\n"

    for topic in sorted(topics):
        section += f"## {topic}\n\n"
        section += "| **Problem** |\n"
        section += "| --- |\n"

        for problem in topics[topic]:
            number = problem["number"]
            title = problem["title"]
            slug = problem["slug"]

            url = (
                f"https://github.com/"
                f"Soubhagya-Kabiraj/Leetcode-Solutions/"
                f"tree/main/{number}-{slug}"
            )

            section += f"| [{number} - {title}]({url}) |\n"

        section += "\n"

    return section


def update_readme():
    with open(README_PATH, "r", encoding="utf-8") as file:
        readme = file.read()

    problems = get_problems()

    new_section = create_topic_section(problems)

    start_marker = "## 🧠 LeetCode Topics"

    end_marker = "## ⭐ About This Repository"

    start = readme.find(start_marker)
    end = readme.find(end_marker)

    if start == -1:
        print("Topics section not found.")
        return

    if end == -1:
        print("About section not found.")
        return

    updated_readme = (
        readme[:start]
        + new_section
        + "\n"
        + readme[end:]
    )

    with open(README_PATH, "w", encoding="utf-8") as file:
        file.write(updated_readme)

    print(f"README updated with {len(problems)} problems.")


if __name__ == "__main__":
    update_readme()
