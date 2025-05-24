import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { createEmployee, getEmployeeById, updateEmployee } from '../Services/EmployeeService'; // Added updateEmployee import
import 'bootstrap/dist/css/bootstrap.min.css';

const EmployeeComponent = () => {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [errors, setErrors] = useState({});
  const navigate = useNavigate();
  const { id } = useParams();

  const validate = () => {
    const newErrors = {};
    if (!firstName.trim()) newErrors.firstName = 'First name is required';
    if (!lastName.trim()) newErrors.lastName = 'Last name is required';
    if (!email.trim()) newErrors.email = 'Email is required';
    return newErrors;
  };

  useEffect(() => {
    if (id) {
      getEmployeeById(id)
        .then((response) => {
          const employee = response.data;
          setFirstName(employee.firstName);
          setLastName(employee.lastName);
          setEmail(employee.email);
        })
        .catch((error) => {
          console.error('Error fetching employee data:', error);
        });
    }
  }, [id]);

  const saveOrUpdateEmployee = (event) => {
    event.preventDefault();

    const validationErrors = validate();
    if (Object.keys(validationErrors).length > 0) {
      setErrors(validationErrors);
      return;
    }

    const employee = { firstName, lastName, email };

    if (id) {
      updateEmployee(id, employee)
        .then(() => navigate('/employees'))
        .catch((error) => console.error('Error updating employee:', error));
    } else {
      createEmployee(employee)
        .then(() => navigate('/employees'))
        .catch((error) => console.error('Error creating employee:', error));
    }
  };

  function pageTitle() {
    return id ? <h2 className="text-center mb-4">Update Employee</h2> : <h2 className="text-center mb-4">Add Employee</h2>;
  }

  return (
    <div className="container py-5">
      <div className="row justify-content-center">
        <div className="col-md-8 col-lg-6 col-xl-5">
          <div className="card shadow p-4">
            {pageTitle()}
            <form onSubmit={saveOrUpdateEmployee}>
              <div className="form-group mb-3">
                <label>First Name:</label>
                <input
                  type="text"
                  className={`form-control ${errors.firstName ? 'is-invalid' : ''}`}
                  placeholder="Enter Employee First Name"
                  value={firstName}
                  onChange={(e) => {
                    setFirstName(e.target.value);
                    setErrors({ ...errors, firstName: '' });
                  }}
                />
                {errors.firstName && <div className="text-danger">{errors.firstName}</div>}
              </div>

              <div className="form-group mb-3">
                <label>Last Name:</label>
                <input
                  type="text"
                  className={`form-control ${errors.lastName ? 'is-invalid' : ''}`}
                  placeholder="Enter Employee Last Name"
                  value={lastName}
                  onChange={(e) => {
                    setLastName(e.target.value);
                    setErrors({ ...errors, lastName: '' });
                  }}
                />
                {errors.lastName && <div className="text-danger">{errors.lastName}</div>}
              </div>

              <div className="form-group mb-3">
                <label>Email ID:</label>
                <input
                  type="email"
                  className={`form-control ${errors.email ? 'is-invalid' : ''}`}
                  placeholder="Enter Employee Email ID"
                  value={email}
                  onChange={(e) => {
                    setEmail(e.target.value);
                    setErrors({ ...errors, email: '' });
                  }}
                />
                {errors.email && <div className="text-danger">{errors.email}</div>}
              </div>

              <button type="submit" className="btn btn-success w-100">
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default EmployeeComponent;
