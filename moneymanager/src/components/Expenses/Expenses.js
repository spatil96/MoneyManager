import React, { Component } from 'react';
import AppNav from '../AppNav';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import '../../App.css';
import { Table, Container, Input, Button, Label, FormGroup, Form } from 'reactstrap';
import { Link } from 'react-router-dom';
import Moment from 'react-moment';

class Expenses extends Component {
  emptyItem = {
    description: '',
    expensedate: new Date(),
    id: 104,
    location: '',
    category: { id: 1, name: 'Travel' },
  };

  constructor(props) {
    super(props);

    this.state = {
      isLoading: true,
      Categories: [],
      Expenses: [],
      item: this.emptyItem,
    };

    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.handleDateChange = this.handleDateChange.bind(this);
  }

  async handleSubmit(event) {
    event.preventDefault(); // Prevent page reload
    const { item } = this.state;

    await fetch(`http://localhost:8083/api/expenses`, {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(item),
    });

    // Refresh the list after submitting
    this.componentDidMount();
  }

  handleChange(event) {
    const { name, value } = event.target;
    this.setState((prevState) => ({
      item: {
        ...prevState.item,
        [name]: value,
      },
    }));
  }

  handleDateChange(date) {
    this.setState((prevState) => ({
      item: {
        ...prevState.item,
        expensedate: date,
      },
    }));
  }

  async remove(id) {
    await fetch(`http://localhost:8083/api/expenses/${id}`, {
      method: 'DELETE',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
    });

    // Refresh the list after deletion
    const updatedExpenses = this.state.Expenses.filter((expense) => expense.id !== id);
    this.setState({ Expenses: updatedExpenses });
  }

  async componentDidMount() {
    // Fetch categories
    const categoryResponse = await fetch('http://localhost:8083/api/categories');
    const Categories = await categoryResponse.json();

    // Fetch expenses
    const expenseResponse = await fetch('http://localhost:8083/api/expenses');
    const Expenses = await expenseResponse.json();

    this.setState({ Categories, Expenses, isLoading: false });
  }

  render() {
    const { Categories, Expenses, isLoading, item } = this.state;

    if (isLoading) {
      return <div>Loading...</div>;
    }

    const categoryOptions = Categories.map((category) => (
      <option value={category.id} key={category.id}>
        {category.name}
      </option>
    ));

    const expenseRows = Expenses.map((expense) => (
      <tr key={expense.id}>
        <td>{expense.description}</td>
        <td>{expense.location}</td>
        <td>
          <Moment date={expense.expensedate} format="YYYY/MM/DD" />
        </td>
        <td>{expense.category.name}</td>
        <td>
          <Button size="sm" color="danger" onClick={() => this.remove(expense.id)}>
            Delete
          </Button>
        </td>
      </tr>
    ));

    return (
      <div>
        <AppNav />
        <Container>
          <h3>Add Expense</h3>
          <Form onSubmit={this.handleSubmit}>
            <FormGroup>
              <Label for="description">Title</Label>
              <Input
                type="text"
                name="description"
                id="description"
                value={item.description}
                onChange={this.handleChange}
                autoComplete="name"
              />
            </FormGroup>

            <FormGroup>
              <Label for="category">Category</Label>
              <Input
                type="select"
                name="category"
                id="category"
                value={item.category.id}
                onChange={(e) =>
                  this.setState((prevState) => ({
                    item: {
                      ...prevState.item,
                      category: { id: e.target.value, name: prevState.Categories.find((cat) => cat.id == e.target.value)?.name },
                    },
                  }))
                }
              >
                {categoryOptions}
              </Input>
            </FormGroup>

            <FormGroup>
              <Label for="expensedate">Date</Label>
              <DatePicker
                selected={item.expensedate}
                onChange={this.handleDateChange}
                dateFormat="yyyy/MM/dd"
              />
            </FormGroup>

            <FormGroup>
              <Label for="location">Location</Label>
              <Input
                type="text"
                name="location"
                id="location"
                value={item.location}
                onChange={this.handleChange}
              />
            </FormGroup>

            <FormGroup>
              <Button color="primary" type="submit">
                Save
              </Button>{' '}
              <Button color="secondary" tag={Link} to="/">
                Cancel
              </Button>
            </FormGroup>
          </Form>
        </Container>

        <Container>
          <h3>Expense List</h3>
          <Table className="mt-4">
            <thead>
              <tr>
                <th width="30%">Description</th>
                <th width="10%">Location</th>
                <th>Date</th>
                <th>Category</th>
                <th width="10%">Action</th>
              </tr>
            </thead>
            <tbody>{expenseRows}</tbody>
          </Table>
        </Container>
      </div>
    );
  }
}

export default Expenses;
