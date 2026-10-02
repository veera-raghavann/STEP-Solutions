import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class OnlineExaminationSystem {

    static abstract class Question {
        private final String questionNumber;
        private final String text;
        private final int points;

        Question(String questionNumber, String text, int points) {
            this.questionNumber = questionNumber;
            this.text = text;
            this.points = points;
        }

        public String getQuestionNumber() {
            return questionNumber;
        }

        public String getText() {
            return text;
        }

        public int getPoints() {
            return points;
        }

        public abstract boolean evaluate(String answer);
    }

    static class MultipleChoiceQuestion extends Question {
        private final String correctOption;

        MultipleChoiceQuestion(
            String number,
            String text,
            int points,
            String correctOption
        ) {
            super(number, text, points);
            this.correctOption = correctOption;
        }

        public boolean evaluate(String answer) {
            return correctOption.equalsIgnoreCase(answer);
        }
    }

    static class TrueFalseQuestion extends Question {
        private final boolean correctAnswer;

        TrueFalseQuestion(
            String number,
            String text,
            int points,
            boolean correctAnswer
        ) {
            super(number, text, points);
            this.correctAnswer = correctAnswer;
        }

        public boolean evaluate(String answer) {
            return Boolean.parseBoolean(answer) == correctAnswer;
        }
    }

    static class ShortAnswerQuestion extends Question {
        private final String correctAnswer;

        ShortAnswerQuestion(
            String number,
            String text,
            int points,
            String correctAnswer
        ) {
            super(number, text, points);
            this.correctAnswer = correctAnswer;
        }

        public boolean evaluate(String answer) {
            return correctAnswer.equalsIgnoreCase(answer.trim());
        }
    }

    static class Student {
        private final String name;

        Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class Examination {
        private final String name;
        private final Map<String, Question> questions = new LinkedHashMap<>();

        Examination(String name) {
            this.name = name;
        }

        public void addQuestion(Question question) {
            questions.put(question.getQuestionNumber(), question);
        }

        public Question getQuestion(String number) {
            return questions.get(number);
        }

        public int getTotalMarks() {
            int total = 0;

            for (Question question : questions.values()) {
                total += question.getPoints();
            }

            return total;
        }

        public String getName() {
            return name;
        }

        public Map<String, Question> getQuestions() {
            return questions;
        }
    }

    static class Attempt {
        private final Student student;
        private final Examination examination;
        private final Map<String, String> answers = new HashMap<>();
        private boolean submitted;

        Attempt(Student student, Examination examination) {
            this.student = student;
            this.examination = examination;
        }

        public void answer(String questionNumber, String answer) {
            if (submitted) {
                System.out.println(
                    "Cannot change answers for a submitted examination."
                );
                return;
            }

            if (examination.getQuestion(questionNumber) == null) {
                System.out.println("Question not found.");
                return;
            }

            answers.put(questionNumber, answer);
            System.out.println(
                "Answer recorded for Question " + questionNumber + "."
            );
        }

        public void submit() {
            if (submitted) {
                System.out.println("Examination has already been submitted.");
                return;
            }

            submitted = true;

            System.out.printf(
                "%s submitted by %s.%n",
                examination.getName(),
                student.getName()
            );

            int totalScore = 0;

            for (Question question : examination.getQuestions().values()) {
                String answer = answers.get(question.getQuestionNumber());
                boolean correct = answer != null && question.evaluate(answer);
                int score = correct ? question.getPoints() : 0;

                totalScore += score;

                System.out.printf(
                    "Result: Question %s: %s (%d points)%n",
                    question.getQuestionNumber(),
                    correct ? "Correct" : "Incorrect",
                    score
                );
            }

            System.out.printf(
                "Total score: %d/%d.%n",
                totalScore,
                examination.getTotalMarks()
            );
        }
    }

    public static void main(String[] args) {
        Student student = new Student("Student 1");
        Examination exam = new Examination("Exam A");

        exam.addQuestion(
            new MultipleChoiceQuestion(
                "1",
                "Which option is correct?",
                5,
                "B"
            )
        );

        exam.addQuestion(
            new TrueFalseQuestion(
                "2",
                "Java supports inheritance.",
                5,
                false
            )
        );

        Attempt attempt = new Attempt(student, exam);

        System.out.println(
            exam.getName() + " started by " + student.getName() + "."
        );

        attempt.answer("1", "C");
        attempt.answer("2", "True");

        attempt.submit();

        attempt.answer("1", "B");
    }
}
