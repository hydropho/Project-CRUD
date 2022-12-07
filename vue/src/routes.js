import HomePage from './pages/HomePage'
import AddStudentPage from './pages/AddStudentPage'
import UpdateStudentPage from './pages/UpdateStudentPage'

export default [
    {
        path: '/',
        name: 'Home',
        component: HomePage,
    },
    {
        path: '/add',
        name: 'Add Student',
        component: AddStudentPage,
    },
    {
        path: '/update/:id',
        name: 'Update Student',
        component: UpdateStudentPage,
    },
]