import http from '../http-common'

class studentService {
    insertStudent(data) {
        return http.post("/student/insert", data);
    }

    getAllStudent() {
        return http.get("/student/getAll");
    }

    updateStudent(id, data) {
        return http.put(`/student/update/${id}`, data);
    }

    deleteStudent(id) {
        return http.delete(`/student/delete/${id}`);
    }

    getSelectedStudent(id) {
        return http.get(`/student/getSelectedStudent/${id}`);
    }
}

export default new studentService();